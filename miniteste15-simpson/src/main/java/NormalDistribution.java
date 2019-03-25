public class NormalDistribution extends ProbabilityDistribution{

    private final String name;
    private double mean;
    private double stddev;

    NormalDistribution(){
        this(0.0, 1.0);
    }

    NormalDistribution(double mean, double stddev){
        this("", mean, stddev);
        if(stddev == 0)
            throw new IllegalArgumentException();

        this.mean = mean;
        this.stddev = stddev;
    }

    NormalDistribution(String name, double mean, double stddev){
        this.name = name;
        addDistribution(this);
    }

    public double getMean() {
        return mean;
    }

    public double getStddev() {
        return stddev;
    }

    @Override
    public double probabilityDensityFunction(double x) {
        return Math.exp(-Math.pow(x-mean, 2)/(2*stddev*stddev))/Math.sqrt(2*Math.PI*stddev*stddev);
    }

    @Override
    public double calcRangeProbability(int a, int b) {
        return 1.0-(probabilityDensityFunction(a)+probabilityDensityFunction(b));
    }

    @Override
    public double calcLeftProbability(double x) {
        if(x < 0)
            return probabilityDensityFunction(x);

        return 1.0 - probabilityDensityFunction(x);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(null == obj)
            return false;

        if(obj.getClass() != NormalDistribution.class)
            return false;

        NormalDistribution n = (NormalDistribution)obj;

        return this.mean == n.getMean() && this.stddev == n.getStddev();
    }

    @Override
    public String toString() {
        return "N("+this.mean+", "+this.stddev+")";
    }

    public String getName() {
        return name;
    }
}
