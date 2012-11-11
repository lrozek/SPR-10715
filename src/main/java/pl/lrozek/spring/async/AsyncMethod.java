package pl.lrozek.spring.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncMethod implements IAsyncMethod {

    private int invocationCount;

    private Thread invcationThread;

    @Override
    @Async
    public void asyncCall() {
        logger.info( "asyncCall called" );
        invcationThread = Thread.currentThread();
        invocationCount++;
    }

    @Override
    public int getInvocationCount() {
        return invocationCount;
    }

    @Override
    public Thread getInvocationThread() {
        return invcationThread;
    }

    private static final Logger logger = LoggerFactory.getLogger( AsyncMethod.class );

}
