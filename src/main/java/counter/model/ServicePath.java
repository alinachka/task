package counter.model;

import lombok.Getter;

@Getter
    public enum ServicePath {

        COUNTER("counter.path");

        private final String path;

        private ServicePath(String pathProperty) {
            this.path = pathProperty;
        }

    }

