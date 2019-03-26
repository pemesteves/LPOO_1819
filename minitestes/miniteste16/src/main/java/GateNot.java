public class GateNot extends LogicGate {

    private LogicVariable output;
    private LogicVariable input;

    GateNot(LogicVariable output, LogicVariable input) throws ColisionException, CycleException {
        this.output = output;
        if(this.output.getCalculatedBy() != null)
            throw new ColisionException();

        this.output.setLogicGate(this);
        this.output.setValue(!input.getValue());
        this.input = input;
        this.input.addLogicGate(this);

        LogicVariable lv[] = this.input.getCalculatedBy().getInputs();
        for(int i = 0; i < lv.length; i++){
            if(this.output.equals(lv[i]))
                throw new CycleException();
        }
    }

    @Override
    public LogicVariable getOutput() {
        return output;
    }

    @Override
    public LogicVariable[] getInputs() {
        LogicVariable lv[] = {input};
        return lv;
    }

    @Override
    public String getSymbol() {
        return "NOT";
    }

    @Override
    public String getFormula() {
        return "NOT("+input.getFormula()+")";
    }

    @Override
    public void setValue(LogicVariable logicVariable) {
        if(this.input.equals(logicVariable))
            this.output.setValue(!input.getValue());
    }

}
