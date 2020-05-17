
package contracts.lookup;

import org.springframework.cloud.contract.spec.Contract;

import java.util.function.Supplier;

import static org.springframework.cloud.contract.verifier.util.ContractVerifierUtil.map;

class shouldCreateLookup implements Supplier<Contract> {

    @Override
    public Contract get() {
        return Contract.make(c -> {
            c.request(r -> {
                r.method("POST");
                r.url("/lookup");
                r.body(map()
                        .entry("summary", "REMOTE WORK")
                        .entry("description", "Test description"));
                r.headers(h -> {
                    h.contentType(h.applicationJson());
                });
            });
            c.response(r -> {
                r.status(r.OK());
                r.headers(h -> {
                    h.contentType(h.applicationJson());
                });
            });
        });
    }

}
