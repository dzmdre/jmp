package ee.helmes.mapping;

/**
 * Created by anton.mazur on 3/10/2017.
 */
public class MappingFunctionalty {

    private Action action;

    public MappingFunctionalty(){
    }

    public String resolveFunctionality() {
        return action.resolveFunctionality();
    }

    public void setAction(Action action){
        this.action = action;
    }

    public Action getAction(){return action;}
}
