/** "Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0. "*/
package SageOneIntegration.SageOneApiEntities;


final class SageOneDatabaseEntityRelationship extends MainEntity {
        private int $key;

        SageOneDatabaseEntityRelationship() {
                this.setInitialized(true);
        }

        public int get$key() { return (this.isInitialized()) ? this.$key : -1; }

        public void set$key(final int $key) { this.$key = (this.isInitialized()) ? $key : this.$key; }
}
