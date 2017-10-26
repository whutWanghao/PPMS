package com.whut.util.TW;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = null;

        List<Item> a = new ArrayList<>();
        List<Item> b = new ArrayList<>();
        List<Item> c = new ArrayList<>();
        List<Item> d = new ArrayList<>();

        while (!(input = in.nextLine()).equals("")) {
            if (isInvalid(input)) {
                String[] s = input.split(" ");
                if (s[3].equals("A")) {
                    addList(a, s);
                } else if (s[3].equals("B")) {
                    addList(b, s);
                } else if (s[3].equals("C")) {
                    addList(c, s);
                } else {
                    addList(d, s);
                }
            } else {
                System.out.println("Error: the booking is invalid!");
            }

        }

        if (a.size() > 0) Collections.sort(a);
        if (b.size() > 0) Collections.sort(b);
        if (c.size() > 0) Collections.sort(c);
        if (d.size() > 0) Collections.sort(d);
        double sumAll = 0;
        System.out.println("收入汇总");
        System.out.println("---");
        System.out.println("场地:A");
        sumAll += printString(a);
        System.out.println("场地:B");
        sumAll += printString(b);
        System.out.println("场地:C");
        sumAll += printString(c);
        System.out.println("场地:D");
        sumAll += printString(d);
        System.out.println("---");
        System.out.println("总计:" + doubleTrans(sumAll) + "元");
    }

    public static boolean isInvalid(String s) {
        String[] str = s.split(" ");
        if (str.length < 4) return false;
        if (str.length > 5) return false;
        if (str.length > 4 && !(str[4].equals("C"))) return false;
        if ((byte) str[3].charAt(0) < 65 || (byte) str[3].charAt(0) > 68) return false;
        //判断日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(str[1]);
        } catch (ParseException e) {
            return false;
        }
        //判断时间
        try {
            String time = str[2];
            if (time.length() != 11) return false;
            String time1 = time.substring(0, 2);
            int t1 = Integer.parseInt(time1);
            String time2 = time.substring(6, 8);
            int t2 = Integer.parseInt(time2);
            if (t1 < 9 || t1 > 21) return false;
            if (t2 <= t1 || t2 > 22) return false;
            if (!(time.substring(2, 3).equals(":") && time.substring(3, 5).equals("00") && time.substring(5, 6).equals("~") && time.substring(8, 9).equals(":") && time.substring(9, 11).equals("00")))
                return false;

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static double printString(List<Item> list) {
        double sum = 0;
        for (Item i : list) {
            if (i.getCancel()) System.out.println(i.getOutput() + " 违约金" + " " + doubleTrans(i.getSum()) + "元");
            else System.out.println(i.getOutput() + " " + doubleTrans(i.getSum()) + "元");
            sum += i.getSum();
        }
        System.out.println("小计：" + doubleTrans(sum) + "元");
        return sum;
    }

    public static void addList(List<Item> list, String[] s) {
        Item item = new Item(s);
        if (s.length == 5) {//判断是否能取消预定
            boolean canceled = false;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getUsername().equals(item.getUsername()) && list.get(i).getOutput().equals(item.getOutput()) && !list.get(i).getCancel()) {
                    list.remove(i);
                    list.add(item);
                    item.setCancel(true);
                    canceled = true;
                    System.out.println("Success: the booking is accepted!");
                }
            }
            if (!canceled) System.out.println("Error: the booking being cancelled does not exist! ");
        } else {//判断是否能添加预定
            boolean flag = true;
            for (Item i : list) {
                if (i.getDay().equals(item.getDay()) && !i.getCancel()) {
                    if (item.getSt() >= i.getSt() && item.getSt() < i.getEnd()) flag = false;
                    if (item.getEnd() > i.getSt() && item.getEnd() <= i.getEnd()) flag = false;
                    if (item.getSt() <= i.getSt() && item.getEnd() >= i.getEnd()) flag = false;
                }
            }
            if (flag) {
                list.add(item);
                System.out.println("Success: the booking is accepted!");
            } else System.out.println(" Error: the booking conflicts with existing bookings! ");
        }
    }

    public static String doubleTrans(double d) {
        if (Math.round(d) - d == 0) {
            return String.valueOf((long) d);
        } else return String.valueOf(d);
    }
}

class Item implements Comparable<Item> {
    private Date start; //用于排序的日期 时分
    private Date day;
    private int st; //预定起始时钟
    private int end; //预定结束时钟
    private String username; //预定人用户名
    private int status; //工作日=0 周末=1
    private boolean cancel; //true是违约 false是未取消过
    private String output;
    private double sum = 0;

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public double getSum() {
        if (status == 0) {//工作日
            if (st < 12) {
                if (end <= 12) {
                    sum = (end - st) * 30;
                } else if (end <= 18) {
                    sum = (12 - st) * 30 + (end - 12) * 50;
                } else if (end <= 20) {
                    sum = (12 - st) * 30 + 300 + (end - 18) * 80;
                } else {
                    sum = (12 - st) * 30 + 300 + 160 + (end - 20) * 60;
                }
            } else if (st < 18) {
                if (end <= 18) {
                    sum = (end - st) * 50;
                } else if (end <= 20) {
                    sum = (18 - st) * 50 + (end - 18) * 80;
                } else {
                    sum = (18 - st) * 50 + 160 + (end - 20) * 60;
                }
            } else if (st < 20) {
                if (end <= 20) {
                    sum = (end - st) * 80;
                } else {
                    sum = (20 - st) * 80 + (end - 20) * 60;
                }
            } else {
                sum = (end - st) * 60;
            }
        } else {//周末
            if (st < 12) {
                if (end <= 12) {
                    sum = (end - st) * 40;
                } else if (end <= 18) {
                    sum = (12 - st) * 40 + (end - 12) * 50;
                } else {
                    sum = (12 - st) * 40 + 300 + (end - 18) * 60;
                }
            } else if (st < 18) {
                if (end <= 18) {
                    sum = (end - st) * 50;
                } else {
                    sum = (18 - st) * 50 + (st - 18) * 60;
                }
            } else {
                sum = (end - st) * 60;
            }
        }
        if (cancel) {//计算违约金
            if (status == 0) {
                sum = sum * 0.5;
            } else sum = sum * 0.25;
        }
        return sum;
    }

    public Item(String[] s) {
        try {
            st = Integer.parseInt(s[2].substring(0, 2));
            end = Integer.parseInt(s[2].substring(6, 8));
            cancel = false;
            username = s[0];
            output = s[1] + " " + s[2];
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            start = format1.parse(s[1] + " " + s[2].substring(0, 5));
            day = format2.parse(s[1]);
            c.setTime(day);
            int i = c.get(Calendar.DAY_OF_WEEK);
            if (i == 1 || i == 7) {
                status = 1;
            } else {
                status = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Date getStart() {
        return start;
    }

    public Date getDay() {
        return day;
    }

    public int getSt() {
        return st;
    }

    public int getEnd() {
        return end;
    }

    public String getUsername() {
        return username;
    }

    public int getStatus() {
        return status;
    }

    public String getOutput() {
        return output;
    }

    public boolean getCancel() {
        return cancel;
    }

    @Override
    public int compareTo(Item i) {
        return this.getStart().compareTo(i.getStart());
    }
}

