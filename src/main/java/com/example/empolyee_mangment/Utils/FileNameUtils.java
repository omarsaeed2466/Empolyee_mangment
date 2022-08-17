package com.example.empolyee_mangment.Utils;

import com.example.empolyee_mangment.constants.ApplicationConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Slf4j
public class FileNameUtils {
    public boolean validFileName(String fileName) {
        boolean validFlag = !StringUtils.containsAny(fileName, "!@#$%^&*");
        log.info("Inside validFileName method of FileNameUtils:: fileName: " + fileName + "validFlag: " + validFlag);
        return validFlag;
    }

    /**
     * Check if the given file type is a valid file type which falls under the
     * acceptable file types.
     *
     * @param fileName
     * @return
     */
    public boolean validFileType(String fileName) {
        log.info("Inside validateFileType method of FileNameUtils");
        Pattern pattern;
        Matcher matcher;
        final String FILETYPE_PATTERN = "(.*\\.(?i)(txt|jpg|jpeg|png|pdf))$";
        pattern = Pattern.compile(FILETYPE_PATTERN);
        matcher = pattern.matcher(fileName);
        boolean validFlag = matcher.matches();
        log.info("validFlag: " + validFlag);
        return validFlag;
    }

    public boolean validFileSize(long fileSize) {
        log.info("Inside validFileSize() method of FileNameUtils");
        //Check if the File size is less than or equal to 5MB
        boolean validFlag = (fileSize <= Long.parseLong(ApplicationConstant.MAX_UPLOAD_FILE_SIZE));
        log.info("validFlag: " + validFlag);
        return validFlag;
    }
}
