package ro.mycode.crudapp.Flowers.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static ro.mycode.crudapp.Flowers.system.Constants.MAKEUP_EXIST;
@ResponseStatus(HttpStatus.OK)
public class FlowerExist extends RuntimeException {

    public FlowerExist() {
        super(MAKEUP_EXIST);
    }
}
