import java.util.ArrayList;
import java.util.List;

public abstract class ProbabilityDistribution {
    private static List<ProbabilityDistribution> distributionList = new ArrayList<>();

    protected static void addDistribution(ProbabilityDistribution probabilityDistribution){
        distributionList.add(probabilityDistribution);
    }

    public static ProbabilityDistribution find(String name){
        for(ProbabilityDistribution probabilityDistribution : distributionList){
            if(probabilityDistribution.getName().equals(name))
                return probabilityDistribution;
        }

        return null;
    }

    protected abstract Object getName();

    public abstract double getMean();
    public abstract double getStddev();
    public abstract double probabilityDensityFunction(double x);
    public abstract double calcRangeProbability(int a, int b);
    public abstract double calcLeftProbability(double x);
}
