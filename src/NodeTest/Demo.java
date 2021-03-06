package NodeTest;

import java.lang.reflect.Array;
import java.util.*;

public class Demo {
    public static void main(String[] args) {
//        SingleLL ll = new SingleLL();
//
//        ll.addNode(1);
//        ll.addNode(2);
//        ll.addNode(3);
//        ll.addNode(4);
//        ll.printList();
//        ll.reverseList();
//        System.out.println();
//        ll.printList();

        int[] array = {4,4,4,5,6,6,6,1,1,4,4,4,4,5};
        int[] arr2 = {6,4,3,2,1,7};

        //System.out.println(findRepeated(array));
        //System.out.println(sumFinder2(arr2, 9));

        BST bst = new BST();

        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);
        bst.add(6);
        bst.add(8);

        bst.traverseTree(bst.root);
        System.out.println();
        bst.invertTree(bst.root);
        bst.traverseTree(bst.root);

    }

        // 1- given an array of integers find the most repeated number
//	findRepeated([4,4,4,5,6,6,6,1,1,4,4,4,4,5]) = 4

    public static int findRepeated(int[] array){

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++){
            if (!map.containsKey(array[i])){
                map.put(array[i], 1);
            } else {
                map.put(array[i], map.get(array[i]) + 1);
            }
        }

        int currentNum = 0;
        int currentMax = 0;

        for (Map.Entry<Integer, Integer> num: map.entrySet()){
            if (num.getValue() > currentMax){
                currentNum = num.getKey();
                currentMax = num.getValue();
            }
        }
        return currentNum;
    }


// 2- From a unsorted array, check whether there are any two numbers that will sum up to a given number
//	sumFinder([6,4,3,2,1,7], 9) = true
//	sumFinder([6,4,3,2,1,7], 2) = false}

    public static boolean sumFinder(int[] array, int value){
        Arrays.sort(array);

        int leftPoint = 0;
        int rightPoint = array.length - 1;

        while (leftPoint < rightPoint){
            if (array[leftPoint] + array[rightPoint] > value) {
                rightPoint--;
            } else if (array[leftPoint] + array[rightPoint] < value){
                leftPoint++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean sumFinder2(int[] array, int value){

        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int i =0; i<array.length; i++){
            int jackpot = value - array[i];

            if (map.containsKey(jackpot)){
                return true;
            }
            map.put(array[i], true);
        }
        return false;
    }

//    public static List<Records> mergeRecords(List<Records> list){
//
//        List<Records> mergedList = new List<records>();
//        String currentWord = "";
//        ArrayList<String> companyList = new ArrayList<>();
//        for (int i =0; i < list.size(); i++){
//            int j =0;
//            while (list.get(i).get(j) != " "){
//                currentWord += list.get(i).get(j);
//                j++;
//            }
//            if(currentWord == "***") {
//                currentWord =" ";
//                continue;
//            }
//            if (!companyList.contains(currentWord)){
//                companyList.add(currentWord);
//                mergedList.add(list.get(i));
//            }
//            currentWord =" ";
//
//        }
//
//        return mergedList;
//    }
}