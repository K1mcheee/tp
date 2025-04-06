package seedu.address.logic;

import static seedu.address.model.student.Email.SPECIAL_CHARACTERS;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.parser.Prefix;
import seedu.address.model.student.Student;

/**
 * Container for user visible messages.
 */
public class Messages {
    // constraints
    public static final String ADDRESS_MESSAGE_CONSTRAINTS =
            "Addresses can take any values, and it should not be blank.";
    public static final String NAME_MESSAGE_CONSTRAINTS =
            "Names should only contain alphanumeric characters and spaces, and it should not be blank.";
    public static final String STUDENT_ID_MESSAGE_CONSTRAINTS =
            "Student ID should be 4 characters beginning with A followed by 2 digits "
                    + "and ending with an alphabet.";
    public static final String PHONE_MESSAGE_CONSTRAINTS =
            "Phone numbers should only contain numbers, and should be between 80000000 and 99999999.";
    public static final String EMAIL_MESSAGE_CONSTRAINTS = "Emails should be of the format local-part@domain "
            + "and adhere to the following constraints:\n"
            + "1. The local-part should only contain alphanumeric characters and these special characters, excluding "
            + "the parentheses, (" + SPECIAL_CHARACTERS + "). The local-part may not start or end with any special "
            + "characters.\n"
            + "2. This is followed by a '@' and then a domain name. The domain name is made up of domain labels "
            + "separated by periods.\n"
            + "The domain name must:\n"
            + "    - End with a domain label at least 2 characters long.\n"
            + "    - Have each domain label start and end with alphanumeric characters.\n"
            + "    - Have each domain label consist of alphanumeric characters, separated only by hyphens, if any.";
    public static final String ATTENDANCE_DATE_CONSTRAINTS = "Attendance can only be marked for today or any day in "
            + "the past. It cannot be marked for future dates.";

    //messages
    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command. Please type \"help\" to check out "
            + "the available commands.";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_STUDENT_ID = "The Student ID provided is invalid!\n"
            + STUDENT_ID_MESSAGE_CONSTRAINTS;
    public static final String MESSAGE_STUDENT_FOUND = "Student with this student ID found.";
    public static final String MESSAGE_DUPLICATE_FIELDS =
                "Multiple values specified for the following single-valued field(s): %1$s.";
    public static final String MESSAGE_STUDENT_ATTENDANCE_MARKED = "Student %1$s marked as present.";
    public static final String MESSAGE_STUDENT_ATTENDANCE_UNMARKED = "Student %1$s marked as absent.";

    public static final String MESSAGE_ALL_STUDENT_ATTENDANCE_UNMARKED = "All students marked as absent.";
    public static final String MESSAGE_ALL_STUDENT_ATTENDANCE_MARKED = "All students marked as present.";
    public static final String MESSAGE_STUDENT_ALREADY_MARKED = "Student %1$s is already marked as present.";
    public static final String MESSAGE_STUDENT_ALREADY_UNMARKED = "Student %1$s is already marked as absent.";

    //used by add
    public static final String MESSAGE_ADD_SUCCESS = "New student added: %1$s";
    public static final String MESSAGE_DUPLICATE_STUDENT = "This student already exists in the CareBook.";

    // used by clear
    public static final String MESSAGE_CLEAR_SUCCESS = "CareBook has been cleared!";

    // used by delete
    public static final String MESSAGE_DELETE_SUCCESS = "Deleted Student: %1$s.";
    public static final String MESSAGE_STUDENT_ID_NOT_FOUND = "No student with student ID: %1$s found.";

    // used by edit
    public static final String MESSAGE_EDIT_STUDENT_SUCCESS = "Edited student: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";

    //used by exit
    public static final String MESSAGE_EXIT_ACKNOWLEDGEMENT = "Exiting Address Book as requested ...";

    // used by export
    public static final String MESSAGE_EXPORT_SUCCESS = "Exported attendance summary to \n%1$s.";
    public static final String FILE_WRITE_ERROR = "Unable to export attendance summary due to I/O error.";
    public static final String EXPORT_FILE_HEADER = "Student ID, Student Name, Parent Name, Parent's Email, "
            + "Parent's Number, Attendance History (Present Dates)\n";
    public static final String MESSAGE_INVALID_FILE_NAME = "File name should only consist of alphanumeric"
            + " characters and underscores (_). " + "\nSpecial characters like ?, /, ., * are invalid.";
    public static final String MESSAGE_FILE_NAME_TOO_LONG = "File name too long. Please choose a shorter name";

    // used by help
    public static final String SHOWING_HELP_MESSAGE = "Opened help window.";

    // used by list
    public static final String MESSAGE_LIST_SUCCESS = "Listed all students.";

    // Used for empty list
    public static final String MESSAGE_EMPTY_STUDENT_LIST = "There are no students in the student list.";

    /**
     * Returns an error message indicating the duplicate prefixes.
     */
    public static String getErrorMessageForDuplicatePrefixes(Prefix... duplicatePrefixes) {
        assert duplicatePrefixes.length > 0;

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return String.format(MESSAGE_DUPLICATE_FIELDS, duplicateFields);
    }

    /**
     * Formats the {@code student} for display to the user.
     */
    public static String format(Student student) {
        final StringBuilder builder = new StringBuilder();
        builder.append(student.getStudentName())
                .append("; Student Id: ")
                .append(student.getStudentId())
                .append("; Parent Name: ")
                .append(student.getParentName())
                .append("; Phone: ")
                .append(student.getPhone())
                .append("; Email: ")
                .append(student.getEmail())
                .append("; Address: ")
                .append(student.getAddress());
        return builder.toString();
    }

}
