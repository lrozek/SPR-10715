package pl.lrozek.spring.async;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.lrozek.spring.config.AsyncConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AsyncConfig.class)
public class AsyncMethodITest {

    @Test
    public void itShouldCallAsyncMethod() throws Exception {
        // given

        // when
        asyncMethod.asyncCall();

        // then
        wait4InvocationInOtherThread();
        assertThat( asyncMethod.getInvocationCount(), is( 1 ) );
        assertThat( asyncMethod.getInvocationThread(), is( not( equalTo( Thread.currentThread() ) ) ) );
    }

    public void wait4InvocationInOtherThread() throws InterruptedException {
        Thread.sleep( 1000 );
    }

    @Autowired
    private IAsyncMethod asyncMethod;

}
