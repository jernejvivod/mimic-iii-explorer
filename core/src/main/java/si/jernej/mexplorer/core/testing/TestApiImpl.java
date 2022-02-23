package si.jernej.mexplorer.core.testing;

import javax.ejb.Stateless;

import si.jernej.mexplorer.core.api.v1.endpoint.TestApi;

@Stateless
public class TestApiImpl implements TestApi
{
    @Override
    public void test(String id)
    {
        System.out.println("here");
    }
}
