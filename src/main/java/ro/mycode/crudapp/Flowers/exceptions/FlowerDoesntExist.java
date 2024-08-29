package ro.mycode.crudapp.Flowers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.crudapp.Flowers.system.Constants.MAKEUP_DOESNT_EXIST;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class FlowerDoesntExist extends RuntimeException{

    public FlowerDoesntExist() {
        super(MAKEUP_DOESNT_EXIST);
    }
}
