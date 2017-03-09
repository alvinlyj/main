package seedu.taskmanager.logic.parser;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import seedu.taskmanager.commons.exceptions.IllegalValueException;
import seedu.taskmanager.commons.util.StringUtil;
// import seedu.taskmanager.model.person.Address;
import seedu.taskmanager.model.task.Date;
import seedu.taskmanager.model.task.TaskName;
import seedu.taskmanager.model.task.Time;
// import seedu.taskmanager.model.tag.Tag;
// import seedu.taskmanager.model.tag.UniqueTagList;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes
 */
public class ParserUtil {

    private static final Pattern INDEX_ARGS_FORMAT = Pattern.compile("(?<targetIndex>.+)");

    /**
     * Returns the specified index in the {@code command} if it is a positive unsigned integer
     * Returns an {@code Optional.empty()} otherwise.
     */
    public static Optional<Integer> parseIndex(String command) {
        final Matcher matcher = INDEX_ARGS_FORMAT.matcher(command.trim());
        if (!matcher.matches()) {
            return Optional.empty();
        }

        String index = matcher.group("targetIndex");
        if (!StringUtil.isUnsignedInteger(index)) {
            return Optional.empty();
        }
        return Optional.of(Integer.parseInt(index));

    }

    /**
     * Returns a new Set populated by all elements in the given list of strings
     * Returns an empty set if the given {@code Optional} is empty,
     * or if the list contained in the {@code Optional} is empty
     */
    public static Set<String> toSet(Optional<List<String>> list) {
        List<String> elements = list.orElse(Collections.emptyList());
        return new HashSet<>(elements);
    }

    /**
    * Splits a preamble string into ordered fields.
    * @return A list of size {@code numFields} where the ith element is the ith field value if specified in
    *         the input, {@code Optional.empty()} otherwise.
    */
    public static List<Optional<String>> splitPreamble(String preamble, int numFields) {
        return Arrays.stream(Arrays.copyOf(preamble.split("\\s+", numFields), numFields))
                .map(Optional::ofNullable)
                .collect(Collectors.toList());
    }

    /**
     * Parses a {@code Optional<String> taskname} into an {@code Optional<TaskName>} if {@code taskname} is present.
     */
    public static Optional<TaskName> parseTaskName(Optional<String> taskname) throws IllegalValueException {
        assert taskname != null;
        return taskname.isPresent() ? Optional.of(new TaskName(taskname.get())) : Optional.empty();
    }

    /**
     * Parses a {@code Optional<String> time} into an {@code Optional<Time>} if {@code time} is present.
     */
    public static Optional<Time> parseTime(Optional<String> time) throws IllegalValueException {
        assert time != null;
        return time.isPresent() ? Optional.of(new Time(time.get())) : Optional.empty();
    }

    /**
     * Parses a {@code Optional<String> date} into an {@code Optional<Date>} if {@code date} is present.
     */
    public static Optional<Date> parseDate(Optional<String> date) throws IllegalValueException {
        assert date != null;
        return date.isPresent() ? Optional.of(new Date(date.get())) : Optional.empty();
    }

    /**
     * Parses a {@code Optional<String> endtime} into an {@code Optional<EndTime>} if {@code endtime} is present.
     */
/*    public static Optional<EndTime> parseEndTime(Optional<String> endtime) throws IllegalValueException {
    	assert endtime != null;
    	return endtime.isPresent() ? Optional.of(new EndTime(endtime.get())) : Optional.empty();
    }


    /**
     * Parses a {@code Optional<String> deadline} into an {@code Optional<Deadline>} if {@code deadline} is present.

    public static Optional<Deadline> parseDeadline(Optional<String> deadline) throws IllegalValueException {
    	assert deadline != null;
    	return deadline.isPresent() ? Optional.of(new Deadline(endtime.get())) : Optinal.empty();
    } */

    /**
     * Parses a {@code Optional<String> address} into an {@code Optional<Address>} if {@code address} is present.
     */
   /* public static Optional<Address> parseAddress(Optional<String> address) throws IllegalValueException {
        assert address != null;
        return address.isPresent() ? Optional.of(new Address(address.get())) : Optional.empty();
    } */


    /**
     * Parses {@code Collection<String> tags} into an {@code UniqueTagList}.
     */
  /*  public static UniqueTagList parseTags(Collection<String> tags) throws IllegalValueException {
        assert tags != null;
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(new Tag(tagName));
        }
        return new UniqueTagList(tagSet);
    } */
}
