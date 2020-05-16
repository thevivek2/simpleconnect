
package contracts.lookup;

import org.springframework.cloud.contract.spec.Contract;

import java.util.function.Supplier;

class shouldGetListOfLookup implements Supplier<Contract> {

	@Override
	public Contract get() {
		return Contract.make(c -> {
            c.request(r -> {
                r.method("GET");
                r.url("/lookup");
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
