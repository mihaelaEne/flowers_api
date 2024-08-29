package ro.mycode.crudapp.Flowers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.crudapp.Flowers.system.Constants.NO_UPDATE;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NoUpdate extends RuntimeException{


    public NoUpdate() {
        super(NO_UPDATE);
    }
}
