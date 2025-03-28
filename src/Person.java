public class Person {
    private String name;
    private String surname;
    private String email;

    public Person(String name,String surname,String email){
        this.name=name;
        this.surname=surname;
        this.email=email;
    }

    public String getName(){
        return name;
    }
    public void setName(String input_name){
        this.name=input_name;
    }
    public String getSurname(){
        return surname;
    }

    public void setSurname(String input_surname){
        this.surname=input_surname;
    }
    public String getEmail(){
        return email;
    }

    public void setEmail(String input_email){
        this.email=input_email;
    }

    public void printing(){
        System.out.println("NAME : "+name.toUpperCase());
        System.out.println("SURNAME : "+surname.toUpperCase());
        System.out.println("EMAIL : "+email);
    }


}

