package seedu.address.model.student;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Student {

    // Identity fields
    private final Name studentName;
    private final StudentId studentId;
    private final Name parentName;
    private final Phone phone;
    private final Email email;
    private Attendance attendance;

    // Data fields
    private final Address address;

    /**
     * Every field must be present and not null.
     */
    public Student(Name studentName, StudentId studentId, Name parentName, Phone phone, Email email, Address address,
                   Attendance attendance) {
        requireAllNonNull(studentName, studentId, parentName, phone, email, address, attendance);
        this.studentName = studentName;
        this.studentId = studentId;
        this.parentName = parentName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.attendance = attendance;
    }


    public Name getStudentName() {
        return studentName;
    }

    public StudentId getStudentId() {
        return studentId;
    }
    public Name getParentName() {
        return parentName;
    }

    public Phone getPhone() {
        return phone;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public boolean getIsPresentToday() {
        return this.attendance.getIsPresentToday();
    }

    public void setPresent() {
        this.attendance.setPresent();
    }

    public void setAbsent() {
        this.attendance.setAbsent();
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSameStudent(Student otherStudent) {
        if (otherStudent == this) {
            return true;
        }

        return otherStudent != null
                && otherStudent.getStudentId().equals(getStudentId());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Student)) {
            return false;
        }

        Student otherStudent = (Student) other;
        return studentName.equals(otherStudent.studentName)
                && studentId.equals(otherStudent.studentId)
                && parentName.equals(otherStudent.parentName)
                && phone.equals(otherStudent.phone)
                && email.equals(otherStudent.email)
                && address.equals(otherStudent.address)
                && attendance.equals(otherStudent.attendance);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(studentName, studentId, parentName, phone, email, address, attendance);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("student name", studentName)
                .add("student ID", studentId)
                .add("parent name", parentName)
                .add("phone", phone)
                .add("email", email)
                .add("address", address)
                .add("attendance", attendance)
                .toString();
    }

}
