package domaineither;

//@Controller
//public class DomainCtr {
//    public ResponseEntity<DemoResponse> demo(DemoRequestParam param) {
//        Either<? extends RuntimeException, DemoResponse> result = domain.getResult(param.toDomainParam());
//        return new ResponseEntity(Match(result)).of(
//                Case($Right($()), v -> v),
//                Case($Left($()), ex -> {throw ex;}));
//        )
//    }
//}
