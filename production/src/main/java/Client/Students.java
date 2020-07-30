package main.java.Client;

public class Students {
     String id;
     String name;
     String count;
     String exp;
     String form;
     String semester;
     String admin_name;
     String height;
     String weight;
     String eyeColor;
     String x;
     String y;

    public Students(String id, String name, String count, String exp, String form, String semester, String admin_name, String height, String weight, String eyeColor, String x, String y) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.exp = exp;
        this.form = form;
        this.semester = semester;
        this.admin_name = admin_name;
        this.height = height;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.x = x;
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCount() {
        return count;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public String getExp() {
        return exp;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getForm() {
        return form;
    }

    public String getHeight() {
        return height;
    }

    public String getSemester() {
        return semester;
    }

    public String getWeight() {
        return weight;
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }
}
