-- sus_01
DROP TABLE IF EXISTS sus_01_info RESTRICT;

-- sus_02
DROP TABLE IF EXISTS sus_02_info RESTRICT;

-- 영양정보
DROP TABLE IF EXISTS nutrition_info RESTRICT;

-- 상품정보
DROP TABLE IF EXISTS product_info RESTRICT;

-- sus_01
CREATE TABLE sus_01_info (
                             sno INTEGER NOT NULL COMMENT '품목번호', -- 품목번호
                             pno INTEGER NOT NULL COMMENT '상품번호' -- 상품번호
)
    COMMENT 'sus_01';

-- sus_01
ALTER TABLE sus_01_info
    ADD CONSTRAINT PK_sus_01_info -- sus_01 기본키
        PRIMARY KEY (
                     sno -- 품목번호
            );

ALTER TABLE sus_01_info
    MODIFY COLUMN sno INTEGER NOT NULL AUTO_INCREMENT COMMENT '품목번호';

-- sus_02
CREATE TABLE sus_02_info (
                             sno INTEGER NOT NULL COMMENT '품목번호', -- 품목번호
                             pno INTEGER NOT NULL COMMENT '상품번호' -- 상품번호
)
    COMMENT 'sus_02';

-- sus_02
ALTER TABLE sus_02_info
    ADD CONSTRAINT PK_sus_02_info -- sus_02 기본키
        PRIMARY KEY (
                     sno -- 품목번호
            );

ALTER TABLE sus_02_info
    MODIFY COLUMN sno INTEGER NOT NULL AUTO_INCREMENT COMMENT '품목번호';

-- 영양정보
CREATE TABLE nutrition_info (
                                nno  INTEGER NOT NULL COMMENT '영양정보번호', -- 영양정보번호
                                pno  INTEGER NOT NULL COMMENT '상품번호', -- 상품번호
                                na   INTEGER NOT NULL COMMENT '나트륨', -- 나트륨
                                car  INTEGER NOT NULL COMMENT '탄수화물', -- 탄수화물
                                sug  INTEGER NOT NULL COMMENT '당류', -- 당류
                                tFat INTEGER NOT NULL COMMENT '트랜스지방', -- 트랜스지방
                                sFat INTEGER NOT NULL COMMENT '포화지방', -- 포화지방
                                chol INTEGER NOT NULL COMMENT '콜레스테롤', -- 콜레스테롤
                                pro  INTEGER NOT NULL COMMENT '단백질' -- 단백질
)
    COMMENT '영양정보';

-- 영양정보
ALTER TABLE nutrition_info
    ADD CONSTRAINT PK_nutrition_info -- 영양정보 기본키
        PRIMARY KEY (
                     nno -- 영양정보번호
            );

ALTER TABLE nutrition_info
    MODIFY COLUMN nno INTEGER NOT NULL AUTO_INCREMENT COMMENT '영양정보번호';

-- 상품정보
CREATE TABLE product_info (
                              pno    INTEGER      NOT NULL COMMENT '상품번호', -- 상품번호
                              pname  VARCHAR(11)  NOT NULL COMMENT '상품명', -- 상품명
                              pprice INTEGER      NOT NULL COMMENT '상품가격', -- 상품가격
                              pcom   VARCHAR(11)  NOT NULL COMMENT '제조사', -- 제조사
                              pphoto VARCHAR(255) NOT NULL COMMENT '상품사진', -- 상품사진
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

-- 영양정보
ALTER TABLE nutrition_info
    ADD CONSTRAINT FK_product_info_TO_nutrition_info -- 상품정보 -> 영양정보
        FOREIGN KEY (
                     pno -- 상품번호
            )
            REFERENCES product_info ( -- 상품정보
                                     pno -- 상품번호
                );