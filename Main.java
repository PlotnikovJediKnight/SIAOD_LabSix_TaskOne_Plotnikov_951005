import java.util.LinkedHashSet;
import java.util.Random;

//СИАОД, Лабораторная работа №6
//Бинарное дерево поиска с симметричной прошивкой
//Плотников Владислав, гр. 951005
//Задача 1

public class Main {
    public static void main(String[] args){
        //Объект для генерации случайных чисел
        Random rand = new Random();
        //LinkedHashSet для исключения дубликатов ключей. Также сохраняет порядок вставки
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
        //Создаем пока обычное двоичное дерево поиска
        BinTree tree = new BinTree();

        //Создаем 1000 ключей и кладем их во множество
        for (int i = 0; i < 10; i++)
            set.add(rand.nextInt(100));
        //Проходимся по множеству и каждый его элемент вставляем в дерево двоичного поиска
        System.out.println("Порядок вставки элементов в двоичное дерево поиска: ");
        for (Integer it : set){
            System.out.print(it + " ");
            tree.insert(it);
        }
        System.out.println();

        //Симметричный обход
        tree.getInOrder();

        //Делаем прошивку
        tree.makeSymmetricallyThreaded();

        //Выводим после прошивки
        tree.threadedInOrderTraverse();
        tree.threadedInOrderTraverseReverse();

        //Вставка ключей в прошитое
        tree.insertToSymmetricTree(-1);
        tree.insertToSymmetricTree(-52);
        tree.insertToSymmetricTree(-250);
        tree.insertToSymmetricTree(120);
        tree.insertToSymmetricTree(170);
        tree.insertToSymmetricTree(130);
        tree.insertToSymmetricTree(150);
        tree.insertToSymmetricTree(190);
        tree.insertToSymmetricTree(410);
        tree.insertToSymmetricTree(-967);

        System.out.println("После вставки новых ключей:");
        tree.threadedInOrderTraverse();

        //Попытки удалить несуществующие ключи
        tree.deleteFromSymmetricTree(99999);
        tree.deleteFromSymmetricTree(-99999);
        tree.deleteFromSymmetricTree(-99990);

        //Удаляем первую половину того, что вставили
        int N = set.size() / 2;
        for (Integer it : set){
            tree.deleteFromSymmetricTree(it);
            N--;
            if (N == 0) break;
        }

        //После удаления
        System.out.println("После удаления:");
        tree.threadedInOrderTraverse();
    }
}
