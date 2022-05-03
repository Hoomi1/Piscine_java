public class Calculator {

    private int sizeArr;
    private int countThread;
    private int maxSize;
    private int minSize;

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public Calculator(int sizeArr, int countThread) {
        this.sizeArr = sizeArr;
        this.countThread = countThread;
    }

    public void SumCol()
    {
        if ((sizeArr % countThread) == 0)
        {
            setMaxSize((sizeArr / countThread));
            int num = countThread * getMaxSize();
            setMinSize(sizeArr - num);
        }
        else
        {
            int num = countThread - 1;
            setMaxSize((sizeArr / num) - 1);
            int num2 = getMaxSize() * num;
            setMinSize(sizeArr - num2);
        }
    }
}
