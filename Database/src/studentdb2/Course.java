/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author localuser
 */
package studentdb2;
import java.io.Serializable;

public class Course implements Serializable {

    private String courseCode;
    private String courseDescription;

    public Course(String courseCode, String courseDescription) {
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
    }

    public String toString() {
        return "Shoe{"
                + "Subject='" + courseCode + '\''
                + ", Description=" + courseDescription
                + '}';
    }

}
