package ro.mycode.crudapp.Flowers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.crudapp.Flowers.system.Constants.MAKEUP_LIST_EMPTY;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FlowerListEmpty extends RuntimeException{

    public FlowerListEmpty() {
        super(MAKEUP_LIST_EMPTY);
    }
}
