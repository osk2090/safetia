-- sus_01
DROP TABLE IF EXISTS sus_01_info RESTRICT;

-- sus_02
DROP TABLE IF EXISTS sus_02_info RESTRICT;

-- 상품정보
DROP TABLE IF EXISTS product_info RESTRICT;

-- sus_01
CREATE TABLE sus_01_info (
    pno INTEGER NOT NULL COMMENT '상품번호' -- 상품번호
)
    COMMENT 'sus_01';

-- sus_02
CREATE TABLE sus_02_info (
    pno INTEGER NOT NULL COMMENT '상품번호' -- 상품번호
)
    COMMENT 'sus_02';

-- 상품정보
CREATE TABLE product_info (
                              pno    INTEGER      NOT NULL COMMENT '상품번호', -- 상품번호
                              pname  VARCHAR(11)  NOT NULL COMMENT '상품명', -- 상품명
                              pprice INTEGER      NOT NULL COMMENT '상품가격', -- 상품가격
                              pcom   VARCHAR(11)  NOT NULL COMMENT '제조사', -- 제조사
                              pphoto VARCHAR(255) NULL     COMMENT '상품사진', -- 상품사진
                              na     INTEGER      NOT NULL COMMENT '나트륨', -- 나트륨
                              car    INTEGER      NOT NULL COMMENT '탄수화물', -- 탄수화물
                              sug    INTEGER      NOT NULL COMMENT '당류', -- 당류
                              tFat   INTEGER      NOT NULL COMMENT '트랜스지방', -- 트랜스지방
                              sFat   INTEGER      NOT NULL COMMENT '포화지방', -- 포화지방
                              chol   INTEGER      NOT NULL COMMENT '콜레스테롤', -- 콜레스테롤
                              pro    INTEGER      NOT NULL COMMENT '단백질' -- 단백질
)
    COMMENT '상품정보';

-- 상품정보
ALTER TABLE product_info
    ADD CONSTRAINT PK_product_info -- 상품정보 기본키
        PRIMARY KEY (
                     pno -- 상품번호
            );

ALTER TABLE product_info
    MODIFY COLUMN pno INTEGER NOT NULL AUTO_INCREMENT COMMENT '상품번호';

-- sus_01
ALTER TABLE sus_01_info
    ADD CONSTRAINT FK_product_info_TO_sus_01_info -- 상품정보 -> sus_01
        FOREIGN KEY (
                     pno -- 상품번호
            )
            REFERENCES product_info ( -- 상품정보
                                     pno -- 상품번호
                );

-- sus_02
ALTER TABLE sus_02_info
    ADD CONSTRAINT FK_product_info_TO_sus_02_info -- 상품정보 -> sus_02
        FOREIGN KEY (
                     pno -- 상품번호
            )
            REFERENCES product_info ( -- 상품정보
                                     pno -- 상품번호
                );


alter table sus_01_info drop constraint FK_product_info_TO_sus_01_info;
alter table sus_02_info drop constraint FK_product_info_TO_sus_02_info;

alter table sus_01_info add constraint FK_product_info_TO_sus_01_info
    foreign key (pno) references product_info (pno)
        on delete cascade
        on update cascade;

alter table sus_02_info add constraint FK_product_info_TO_sus_02_info
    foreign key (pno) references product_info (pno)
        on delete cascade
        on update cascade;