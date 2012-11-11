package pl.lrozek.spring.async;

public interface IAsyncMethod {

    void asyncCall();

    int getInvocationCount();

    Thread getInvocationThread();

}
