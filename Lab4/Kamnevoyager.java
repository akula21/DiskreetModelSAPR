package lab4;
import java.io.IOException;
import java.util.Stack;

public class Kamnevoyager {
    private static class State{
        public int cityNum;
        public int nextIndex;
        public boolean isStartPoint;
        public State prev;

        public State(State prev,int city){
            this.prev=prev;
            cityNum=city;
            isStartPoint=false;
        }
        public State(State prev,int city,boolean start){
            this.prev=prev;
            cityNum=city;
            isStartPoint=start;
        }

        public int calculateLength(Graph graph){
            State current=this;
            int sum=0;

            while(current.prev!=null){
                sum+=graph.getEdge(current.prev.cityNum,current.cityNum);
                current=current.prev;
            }

            return sum;
        }

        @Override
        public String toString(){
            if(prev==null)return Integer.toString(cityNum);
            else{
                return prev.toString()+" "+Integer.toString(cityNum);
            }
        }
    }

    public static final void main(String args[]) throws IOException{
        String filename = "src/lab4/lab4.txt";

        Graph graph=Graph.load(filename);

        Stack<State> states=new Stack<>();

       

        System.out.println("¬х≥дна матриц€:");
        System.out.println(graph);
        State state = null;
        state = new State(state,0,true);
        states.push(state);
        graph.enter(state.cityNum);
        State shortest=null;

        state=states.pop();

        while(!state.isStartPoint||!(state.nextIndex>=graph.getCount())){
            int index=state.nextIndex++;

            if(index>=graph.getCount()){
                graph.leave(state.cityNum);
                state=states.pop();
            }else if(graph.hasEdge(state.cityNum,index)&&graph.enter(index)){
                states.push(state);
                state=new State(state,index);
            }

            if(graph.allVisited()){
                if(shortest==null){
                    shortest=state;

                }else{
                    if(shortest.calculateLength(graph)>state.calculateLength(graph)){
                        shortest=state;
                    }
                }
            }
        }

        String result  = shortest.toString();

        System.out.println("–езультат:");
        for (String s : result.split(" ")){
            System.out.print((char) (Integer.parseInt(s) + 65) + " ");
        }
    }
}
