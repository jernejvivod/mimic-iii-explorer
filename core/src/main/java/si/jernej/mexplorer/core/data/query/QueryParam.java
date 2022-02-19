package si.jernej.mexplorer.core.data.query;

public class QueryParam
{
    private boolean selectInTwoSteps;
    private int itemsPerPage;

    public boolean isSelectInTwoSteps()
    {
        return selectInTwoSteps;
    }

    public void setSelectInTwoSteps(boolean selectInTwoSteps)
    {
        this.selectInTwoSteps = selectInTwoSteps;
    }

    public int getItemsPerPage()
    {
        return itemsPerPage;
    }

    public void setItemsPerPage(int itemsPerPage)
    {
        this.itemsPerPage = itemsPerPage;
    }
}
