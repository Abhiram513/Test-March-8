class Employee {
    String fullName;
    int pointLevel;
    String assignedCategory;

    Employee(String fullName, int pointLevel, String assignedCategory) {
        this.fullName = fullName;
        this.pointLevel = pointLevel;
        this.assignedCategory = assignedCategory;
    }
}

class Ticket {
    int id;
    String name;
    String category;
    int point;
    String assignedEmployee = "";
    boolean isCompleted = false;

    Ticket(int id, String name, String category, int point) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.point = point;
    }
}

class HelpDesk {
    Employee emp1, emp2;
    Ticket t1, t2, t3, t4, t5;

    void addEmployee(Employee e, int pos) {
        if (pos == 1) {
            emp1 = e;
        } else if (pos == 2) {
            emp2 = e;
        }
    }

    void addTicket(Ticket t, int pos) {
        if (pos == 1) t1 = t;
        else if (pos == 2) t2 = t;
        else if (pos == 3) t3 = t;
        else if (pos == 4) t4 = t;
        else if (pos == 5) t5 = t;
    }

    void completeTicket(String employeeName, int ticketId) {
        Employee emp = null;
        if (emp1 != null && emp1.fullName.equals(employeeName)) emp = emp1;
        else if (emp2 != null && emp2.fullName.equals(employeeName)) emp = emp2;
        if (emp == null) return;

        Ticket ticket = null;
        if (t1 != null && t1.id == ticketId) ticket = t1;
        else if (t2 != null && t2.id == ticketId) ticket = t2;
        else if (t3 != null && t3.id == ticketId) ticket = t3;
        else if (t4 != null && t4.id == ticketId) ticket = t4;
        else if (t5 != null && t5.id == ticketId) ticket = t5;
        if (ticket == null || ticket.isCompleted) return;

        if (emp.pointLevel >= ticket.point) {
            ticket.isCompleted = true;
            ticket.assignedEmployee = employeeName;
            System.out.println("Ticket " + ticketId + " marked as completed by " + employeeName + ".");
        } else {
            System.out.println("Ticket " + ticketId + " cannot be completed by " + employeeName + " (Insufficient points).");
        }
    }

    int getWaitingTicketCount() {
        int count = 0;
        if (t1 != null && !t1.isCompleted) count++;
        if (t2 != null && !t2.isCompleted) count++;
        if (t3 != null && !t3.isCompleted) count++;
        if (t4 != null && !t4.isCompleted) count++;
        if (t5 != null && !t5.isCompleted) count++;
        return count;
    }

    int getCompletedTicketsTotalPoint() {
        int total = 0;
        if (t1 != null && t1.isCompleted) total += t1.point;
        if (t2 != null && t2.isCompleted) total += t2.point;
        if (t3 != null && t3.isCompleted) total += t3.point;
        if (t4 != null && t4.isCompleted) total += t4.point;
        if (t5 != null && t5.isCompleted) total += t5.point;
        return total;
    }
}

public class HelpDskManage {
    public static void main(String[] args) {
        HelpDesk helpDesk = new HelpDesk();
        Employee abhiram = new Employee("Abhiram B", 5, "SOFTWARE");
        Employee venu = new Employee("Venu T", 8, "HARDWARE");
        helpDesk.addEmployee(abhiram, 1);
        helpDesk.addEmployee(venu, 2);

        Ticket t1 = new Ticket(101, "Software Bug", "SOFTWARE", 4);
        Ticket t2 = new Ticket(102, "Network Issue", "HARDWARE", 7);
        Ticket t3 = new Ticket(103, "System Crash", "HARDWARE", 10);
        Ticket t4 = new Ticket(104, "Printer Not Working", "HARDWARE", 3);
        Ticket t5 = new Ticket(105, "UI Bug", "SOFTWARE", 2);

        helpDesk.addTicket(t1, 1);
        helpDesk.addTicket(t2, 2);
        helpDesk.addTicket(t3, 3);
        helpDesk.addTicket(t4, 4);
        helpDesk.addTicket(t5, 5);

        helpDesk.completeTicket("Abhiram B", 101);
        helpDesk.completeTicket("Venu T", 102);
        helpDesk.completeTicket("Abhiram B", 103);
        helpDesk.completeTicket("Venu T", 104);
        helpDesk.completeTicket("Abhiram B", 105);

        System.out.println(helpDesk.getWaitingTicketCount());
        System.out.println(helpDesk.getCompletedTicketsTotalPoint());
    }
}
