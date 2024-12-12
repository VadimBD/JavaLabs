module order.storage {
    requires java.base;
    requires javafaker;
    requires order.process;
    requires java.sql;
    requires thread.management;
    exports org.example.storage;
}