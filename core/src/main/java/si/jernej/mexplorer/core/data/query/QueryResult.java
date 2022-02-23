package si.jernej.mexplorer.core.data.query;

import java.util.List;

public class QueryResult<T>
{

    private List<T> pageData;
    private boolean selectInTwoSteps;

    public QueryResult(List<T> pageData, boolean selectInTwoSteps)
    {
        this.pageData = pageData;
        this.selectInTwoSteps = selectInTwoSteps;
    }

    public List<T> getPageData()
    {
        return pageData;
    }

    public void setPageData(List<T> pageData)
    {
        this.pageData = pageData;
    }
}
