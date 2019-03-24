import java.util.ArrayList;
import java.util.List;

public class LogicVariable {

    private String name;
    private boolean value;
    private LogicGate logicGate;
    private List<LogicGate> inputLogicGates;

    LogicVariable(String name){
        this(name, false);
    }

    LogicVariable(String name, boolean value){
        this.name = name;
        this.value = value;
        this.logicGate = null;
        inputLogicGates = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
        for(LogicGate lg : inputLogicGates){
            lg.setValue(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(null == obj)
            return false;

        LogicVariable lv = (LogicVariable)obj;

        return this.name.equals(lv.getName());
    }

    public LogicGate getCalculatedBy(){
        return this.logicGate;
    }

    public void setLogicGate(LogicGate logicGate) {
        this.logicGate = logicGate;
    }

    public String getFormula(){
        if(this.logicGate == null)
            return this.name;

        return this.logicGate.getFormula();
    }

    public void addLogicGate(LogicGate logicGate){
        this.inputLogicGates.add(logicGate);
    }

    public boolean hasGate(LogicGate logicGate){
        for(LogicGate lg : inputLogicGates){
            if(lg.equals(logicGate))
                return true;
        }
        return false;
    }
}
