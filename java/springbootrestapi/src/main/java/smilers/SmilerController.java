package smilers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.ArrayList;

@RestController
public class SmilerController {

@RequestMapping("/smilers")
public List<Smiler> smilers() {
  Smiler waban, flbal, dariv;
  waban = new Smiler(1, "waban");
  flbal = new Smiler(2, "flbal");
  dariv = new Smiler(3, "dariv");
  List<Smiler> result = new ArrayList<Smiler>();
  result.add(waban);
  result.add(flbal);
  result.add(dariv);
  return result;
}

}
