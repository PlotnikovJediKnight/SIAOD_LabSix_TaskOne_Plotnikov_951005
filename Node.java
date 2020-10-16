//Класс-узел
class Node {
    public int data;                    //Хранимые данные (ключ)
    public boolean lIsNotThread;        //Истина, если ссылка на левое поддерево НЕ является нитью
    public boolean rIsNotThread;        //Истина, если ссылка на правое поддерево НЕ является нитью
    public Node left;                   //Ссылка на левое поддерево
    public Node right;                  //Ссылка на правое поддерево

    public Node(int data){              //Конструтор для инициализации
        this.data = data;
        lIsNotThread = true;
        rIsNotThread = true;
        left  = null;
        right = null;
    }

    //Метод для вывода ключа
    public void show() { System.out.print(data + " "); }
}
