public class Queue {
    private final int MAX_PERSON = 5;
    private Person list[] = new Person[MAX_PERSON];
    private int push = 0;
    private int pop = 0;
    private boolean end = true;
    private int k = 0; //reader poiner
    
    public Queue(){}

    public boolean pushPerson(Person p){
        if(push > list.length-1){
            if(pop == 0){
                return false;
            }else{
                shift();
                list[push] = p;
                push++;
                return true;
            }
        }else{
            list[push] = p;
            push++;
            return true;
        }
    }

    public void shift(){
        for(int i = 0; i<pop; i ++){
            for(int j = pop; j < push; j++){
                list[j-1] = list[j];
            }
            pop--;
            push--;
        }
    }

    public Person popPerson(){
        int k = pop;
        pop++;
        if(pop > list.length) pop=0;
        return list[k];
    }

    public Person read(){
        if(end){
            end = false;
            k = pop;
        }
        Person p = list[k];
        k++;
        if(k > list.length) k = 0;
        if(k == push){
            end = true;
            return null;
        }
        return p;
    }

    public int getPush() {
        return push;
    }

    public void setPush(int push) {
        this.push = push;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }
}