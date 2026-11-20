package select;
import select.Student;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class Select {
    public static void showAll(ArrayList<Student> list){
        for(int i=0;i< list.size();i++){
            System.out.print(list.get(i).getName()+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        ArrayList<Student> names=new ArrayList<>();
        while(true){
            System.out.println("-------------菜单------------");
            System.out.println("1.添加名字");
            System.out.println("2.删除名字");
            System.out.println("3.抽一个少一个的方法");
            System.out.println("4.直接抽");
            System.out.println("5.显示里面已经存入的名字");
            System.out.println("6.退出");
            System.out.println("请输入你的选择: ");
            int choice=sc.nextInt();
            int number=0;
            while(true){
                if(choice>=1&&choice<=6){break;}else{
                    if(number==3){
                        System.out.println("系统退回菜单");
                        break;}else{
                        System.out.println("您的输入不合法！请重新输入");
                        number++;
                        choice=sc.nextInt();}
                }
            }
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.println("接下来你可以添加人员(按0退回菜单)");
                    while(true){
                        String name1 = sc.nextLine().trim();
                        if(name1.equals("0")){break;}
                        if (name1.equals("")) {
                            System.out.println("名字不能为空,请您重新输入！");
                            continue;}
                        Student s=new Student(name1);
                        if (names.contains(s)) {
                            System.out.println("该名字已存在，当前列表：");
                            showAll(names);
                            System.out.println();
                            System.out.println("请您重新输入!");
                            continue;
                        }
                        names.add(s);
                        System.out.println(s.getName() + " 添加成功！当前共 " + names.size() + " 人。");
                    }
                    break;
                case 2:
                    while(true){
                        if(names.isEmpty()){
                            System.out.println("当前没有人员存入，无法删除，请您添加后再删除!");
                            break;
                        }else{
                            System.out.println("当前已存入人员列表：");
                            showAll(names);
                            System.out.println();
                            System.out.println("请输入你要删除的名字(输入0后退回菜单)");
                            String name2 = sc.nextLine();
                            if(name2.equals("0")){break;}
                            boolean found = false;
                            for(int i = 0; i < names.size(); i++){
                                if(names.get(i).getName().equals(name2)){
                                    names.remove(i);
                                    System.out.println(name2 + " 已经删除，现在还有 " + names.size() + " 人。");
                                    found = true;
                                    break;
                                }}
                            if(!found){
                                System.out.println("您输入的名字有误！请检查是否有此人或者输入错误!");
                            }
                        }}break;
                case 3:
                    if(names.size()==0){
                        System.out.println("当前没有人员存入，请先添加人员后操作！");
                        break;
                    }else{
                        System.out.println("当前是抽取人(不重复)");
                    while(true){
                    System.out.println("下面是所以已添加的学生: ");
                    showAll(names);
                        System.out.println("返回菜单请输入0，进行多次抽取请输入1(抽取名字不重复)，单次抽取请输入其他字符(除了0和1)");
                    String tf=sc.nextLine();
                    if(tf.equals("0")){break;}else if(tf.equals("1")){
                        System.out.println("请输入您要抽取的人员位数(请小于"+names.size()+"次):");
                        int stuNumber= sc.nextInt();
                       if(stuNumber< names.size()){
                           for (int i = 0; i < stuNumber; i++) {
                               int a = r.nextInt(names.size());
                               System.out.print("第"+(i+1)+"次抽取到的人为:");
                               System.out.print(" "+names.get(a).getName()+" ");
                               names.remove(a);
                               System.out.println();
                           }
                           break;
                       }else{
                           System.out.println("当前已存入人员总数为:"+ names.size()+"请输入小于等于这个数的值!");
                           break;
                       }
                    }
                    else {
                        if(names.size()==0){
                            System.out.println("当前已经没有人员了，请添加完再抽取!");
                            break;
                        }else{
                        int a = r.nextInt(names.size());
                            System.out.print("当前抽取到的人是: ");
                        System.out.println(" "+names.get(a).getName());
                        names.remove(a);
                    }
                    }
                    }
                    }
                    break;
                case 4:
                    if(names.isEmpty()){
                        System.out.println("当前没有人员存入,请添加后再进行抽取!");
                    }else{
                    System.out.println("当前直接抽取，有概率会重复抽到同一人(输入0退回菜单)");
                    while (true){
                        System.out.println("下面是全部已添加的人员");
                        showAll(names);
                        System.out.println();
                    System.out.println("接下来输入1可以进行多次抽取,输入0退回菜单,输入其他字符进行一次抽取");
                    String tf2=sc.nextLine();
                    if(tf2.equals("0")){
                        break;
                    } else if (tf2.equals("1")) {
                        System.out.println("请输入你要抽取的次数(但不能高于"+names.size()+"次)");
                        int twice=sc.nextInt();
                        if(twice>=1&&twice<= names.size()){
                            for (int i = 0; i < twice; i++) {
                                int l=r.nextInt(names.size());
                                System.out.println("第"+(i+1)+"次抽取到的人为: "+names.get(l).getName());
                            }
                            sc.nextLine();
                        }else{
                            System.out.println("您输入的次数太多或不合法");
                            break;
                        }
                    }else {
                        int twice2=r.nextInt(names.size());
                        System.out.println("本次抽取到的人为:"+names.get(twice2).getName());
                    }
                    }}
                    break;
                case 5:
                    if(names.isEmpty()){
                        System.out.println("当前还未有人员存入，请您先存入后再查看!(菜单处输入1进行人员存入)");
                        break;
                    }else{
                    System.out.println("当前已存入:");
                    showAll(names);
                    System.out.println();
                    break;}
                case 6:
                    System.exit(0);
                    break;
            }

        }
    }
}

