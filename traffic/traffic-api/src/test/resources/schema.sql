CREATE TABLE IF NOT EXISTS tb_bus_stop
(

    bus_stop_id              text not null primary key,

    bus_stop_name            text not null,

    information_collect_date timestamp default now(),

    city                     text,

    detail_city              text,

    city_code                text,

    mobile_code              text,

    longitude                text,

    latitude                 text
);
CREATE INDEX IF NOT EXISTS tb_bus_stop_bus_stop_name_index ON tb_bus_stop (bus_stop_name);