import java.io.FileWriter;
import java.io.IOException;

public class Ticket {
    private String row;
    private int seat;
    private int price;
    private Person person;

    public Ticket(String row,int seat,int price,Person person){
        this.row=row;
        this.seat=seat;
        this.price=price;
        this.person=person;
    }

    public String getRow(){
        return row;
    }
    public void setRow(String input_row){
        this.row=input_row;
    }
    public int getSeat(){
        return seat;
    }
    public void setSeat(int input_seat){
        this.seat=input_seat;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int input_price){
        this.price=input_price;
    }
    public Person getPerson(){
        return person;
    }

    public void setPerson(Person person){
        this.person=person;
    }

    public void save() throws IOException {
        String fileName=row+Integer.toString(seat)+".txt";
        try {
            FileWriter writer=new FileWriter(fileName+".txt");
            writer.write("Name: "+person.getName()+"\n");
            writer.write("Surname: "+person.getSurname()+"\n");
            writer.write("Email: "+person.getEmail()+"\n");
            writer.write("Row: "+row+"\n");
            writer.write("Seat Number: "+seat+"\n");
            writer.write("Price: "+price);
            writer.close();
        }
        catch (IOException e){
            System.out.println("Something happened while saving Tickets: "+fileName);
            e.printStackTrace();
        }

    }

    public void printing(){
        System.out.println("------------------------------");
        System.out.println("Details of person");
        person.printing();
        System.out.println("------------------------------");
        System.out.println("Details of seat");
        System.out.println("Row:"+row);
        System.out.println("Seat:"+seat);
        System.out.println("Price:"+price);
        System.out.println("------------------------------");

    }



}

