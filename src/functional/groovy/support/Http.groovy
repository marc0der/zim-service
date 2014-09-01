package support

import wslite.rest.RESTClient

class Http {
    static primeRestClient() {
        new RESTClient("http://localhost:8080")
    }

    static getInvader(RESTClient client, String invader) {
        client.get(path: "/invader/${invader}")
    }
}
