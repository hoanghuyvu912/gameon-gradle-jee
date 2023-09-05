package org.practice.exception;

import java.util.HashMap;
import java.util.Map;

public class ErrorMessage {

    //DEVELOPER
    public static final String GAME_NOT_FOUND = "Game not found";
    public static final String KEY_GAME_NOT_FOUND = "exception.resource.not.found.game";
    public static final String GAME_ALREADY_EXISTED = "Game already exists";
    public static final String KEY_GAME_ALREADY_EXISTED = "exception.input.validation.GAME.already.exists";
    public static final String GAME_NAME_LENGTH_CONSTRAINT = "Game name length cannot exceed 255 characters";
    public static final String KEY_GAME_NAME_LENGTH_CONSTRAINT = "exception.input.validation.skill.name.length.over.max.length";
    public static final String GAME_DESCRIPTION_LENGTH_CONSTRAINT = "Game description length cannot exceed 2000 characters";
    public static final String KEY_GAME_DESCRIPTION_LENGTH_CONSTRAINT = "exception.input.validation.skill.description.over.max.length";
    public static final String GAME_NAME_NULL_OR_BLANK = "Game name cannot be null or blank";
    public static final String KEY_GAME_NAME_NULL_OR_BLANK = "exception.input.validation.game.name.blank.or.null";

    //DEVELOPER
    public static final String DEVELOPER_NOT_FOUND = "Developer not found";
    public static final String KEY_DEVELOPER_NOT_FOUND = "exception.resource.not.found.developer";
    public static final String DEVELOPER_ALREADY_EXISTED = "Developer already exists";
    public static final String KEY_DEVELOPER_ALREADY_EXISTED = "exception.input.validation.developer.already.exists";
    public static final String DEVELOPER_NAME_LENGTH_CONSTRAINT = "Developer name length cannot exceed 255 characters";
    public static final String KEY_DEVELOPER_NAME_LENGTH_CONSTRAINT = "exception.input.validation.skill.name.length.over.max.length";
    public static final String DEVELOPER_DESCRIPTION_LENGTH_CONSTRAINT = "Developer description length cannot exceed 2000 characters";
    public static final String KEY_DEVELOPER_DESCRIPTION_LENGTH_CONSTRAINT = "exception.input.validation.skill.description.over.max.length";
    public static final String DEVELOPER_NAME_NULL_OR_BLANK = "Developer Name cannot be null or blank";
    public static final String KEY_DEVELOPER_NAME_NULL_OR_BLANK = "exception.input.validation.developer.name.blank.or.null";

    //PUBLISHER
    public static final String PUBLISHER_NOT_FOUND = "PUBLISHER not found";
    public static final String KEY_PUBLISHER_NOT_FOUND = "exception.resource.not.found.publisher";
    public static final String PUBLISHER_ALREADY_EXISTED = "Publisher already exists";
    public static final String KEY_PUBLISHER_ALREADY_EXISTED = "exception.input.validation.publisher.already.exists";
    public static final String PUBLISHER_NAME_LENGTH_CONSTRAINT = "Publisher name length cannot exceed 255 characters";
    public static final String KEY_PUBLISHER_NAME_LENGTH_CONSTRAINT = "exception.input.validation.skill.name.length.over.max.length";
    public static final String PUBLISHER_DESCRIPTION_LENGTH_CONSTRAINT = "Publisher description length cannot exceed 2000 characters";
    public static final String KEY_PUBLISHER_DESCRIPTION_LENGTH_CONSTRAINT = "exception.input.validation.skill.description.over.max.length";
    public static final String PUBLISHER_NAME_NULL_OR_BLANK = "Publisher name cannot be null or blank";
    public static final String KEY_PUBLISHER_NAME_NULL_OR_BLANK = "exception.input.validation.PUBLISHER.name.blank.or.null";

    //USER
    public static final String KEY_USER_ALREADY_EXISTED = "exception.input.validation.user.already.existed";
    public static final String USER_ALREADY_EXISTED = "User already existed";
    public static final String USER_NAME_LENGTH_CONSTRAINT = "User Name cannot exceed 255 characters";
    public static final String KEY_USER_NAME_LENGTH_CONSTRAINT = "exception.input.validation.user.name.over.max.length";
    public static final String EMAIL_BLANK_OR_NULL = "Email cannot be blank or null";
    public static final String KEY_EMAIL_BLANK_OR_NULL = "exception.input.validation.email.blank.or.null";
    public static final String PASSWORD_BLANK_OR_NULL = "Password cannot be blank or null";
    public static final String KEY_PASSWORD_BLANK_OR_NULL = "exception.input.validation.password.blank.or.null";
    public static final String EMAIL_WRONG_FORMAT = "Email is not the right format";
    public static final String KEY_EMAIL_WRONG_FORMAT = "exception.input.validation.email.wrong.format";
    public static final String PASS_EMAIL_INVALID = "Email or Password is wrong.";
    public static final String KEY_PASS_EMAIL_INVALID = "exception.input.validation.user.email.password.wrong";

    //Authorization
    public static final String UNAUTHORIZED_ACCESS = "Unauthorized Access";
    public static final String KEY_UNAUTHORIZED_ACCESS = "exception.security.unauthorized.access";
    public static final String FORBIDDEN_ACCESS = "Forbidden Access";
    public static final String KEY_FORBIDDEN_ACCESS = "exception.security.forbidden.access";
    public static final String PASSWORD_NOT_MATCH_PATTERN = "Password must be at least 6 characters and at least 1 number";
    public static final String KEY_PASSWORD_NOT_MATCH_PATTERN = "exception.input.validation.password.not.match.pattern";
    public static final String PASSWORD_NOT_ENCODED = "Password is not encoded";
    public static final String KEY_PASSWORD_NOT_ENCODED = "exception.input.validation.password.not.encoded";

    private ErrorMessage() {
    }

    static Map<String, String> errorKeyAndMessageMap() {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put(GAME_NAME_NULL_OR_BLANK, KEY_DEVELOPER_NAME_NULL_OR_BLANK);
        errorMap.put(GAME_NAME_LENGTH_CONSTRAINT, KEY_DEVELOPER_NAME_LENGTH_CONSTRAINT);

        errorMap.put(DEVELOPER_NAME_NULL_OR_BLANK, KEY_DEVELOPER_NAME_NULL_OR_BLANK);
        errorMap.put(DEVELOPER_NAME_LENGTH_CONSTRAINT, KEY_DEVELOPER_NAME_LENGTH_CONSTRAINT);

        errorMap.put(PUBLISHER_NAME_NULL_OR_BLANK, KEY_DEVELOPER_NAME_NULL_OR_BLANK);
        errorMap.put(PUBLISHER_NAME_LENGTH_CONSTRAINT, KEY_DEVELOPER_NAME_LENGTH_CONSTRAINT);

        errorMap.put(USER_NAME_LENGTH_CONSTRAINT, KEY_USER_NAME_LENGTH_CONSTRAINT);
        errorMap.put(EMAIL_BLANK_OR_NULL, KEY_EMAIL_BLANK_OR_NULL);
        errorMap.put(EMAIL_WRONG_FORMAT, KEY_EMAIL_WRONG_FORMAT);
        errorMap.put(PASSWORD_BLANK_OR_NULL, KEY_PASSWORD_BLANK_OR_NULL);

        return errorMap;
    }
}
