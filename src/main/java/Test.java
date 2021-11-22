

public class Test {
    public static void main(String[] args) throws IllegalAccessException {
        Lists lists = new Lists();

        for (int i = 0; i < 10; i++){
            lists.add(i);
        }
        System.out.println(lists);
        lists.removeAll();
        try{
            System.out.println(lists.getIndx(0));
        }
        catch (IllegalAccessException e){
            System.out.println("no index...");
        }
    }
}
