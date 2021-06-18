-- sus_01
DROP TABLE IF EXISTS sus_01_info;

-- sus_02
DROP TABLE IF EXISTS sus_02_info;

-- 영양정보
DROP TABLE IF EXISTS nutrition_info;

-- 상품정보
DROP TABLE IF EXISTS product_info;

-- sus_01
CREATE TABLE sus_01_info (
    pno INTEGER NOT NULL -- 번호
);

-- sus_02
CREATE TABLE sus_02_info (
    pno INTEGER NOT NULL -- 번호
);

-- 영양정보
CREATE TABLE nutrition_info (
    pno INTEGER NOT NULL -- 번호,
        na INTEGER NOT NULL -- 나트륨,
        car INTEGER NOT NULL -- 탄수화물,
        sug INTEGER NOT NULL -- 당류,
        tFat INTEGER NOT NULL -- 트랜스지방,
        sFat INTEGER NOT NULL -- 포화지방,
        chol INTEGER NOT NULL -- 콜레스테롤,
        pro INTEGER NOT NULL -- 단백질
);

-- 상품정보
CREATE TABLE product_info (
    pno INTEGER NOT NULL -- 번호,
        pname VARCHAR(11) NOT NULL -- 상품명,
        pprice INTEGER NOT NULL -- 상품가격,
        pcom VARCHAR(11) NOT NULL -- 제조사,
        pphoto VARCHAR(255) NOT NULL -- 상품사진
);

-- 상품정보
ALTER TABLE product_info
    ADD CONSTRAINT PK_product_info -- 상품정보 기본키
        PRIMARY KEY (
                     pno -- 번호
            );

ALTER TABLE product_info
    MODIFY COLUMN pno INTEGER NOT NULL AUTO_INCREMENT;

ALTER TABLE product_info
    MODIFY COLUMN pno INTEGER NOT NULL AUTO_INCREMENT(1,1);

-- sus_01
ALTER TABLE sus_01_info
    ADD CONSTRAINT FK_product_info_TO_sus_01_info -- 상품정보 -> sus_01
        FOREIGN KEY (
                     pno -- 번호
            )
            REFERENCES product_info ( -- 상품정보
                                     pno -- 번호
                );

-- sus_02
ALTER TABLE sus_02_info
    ADD CONSTRAINT FK_product_info_TO_sus_02_info -- 상품정보 -> sus_02
        FOREIGN KEY (
                     pno -- 번호
            )
            REFERENCES product_info ( -- 상품정보
                                     pno -- 번호
                );

-- 영양정보
ALTER TABLE nutrition_info
    ADD CONSTRAINT FK_product_info_TO_nutrition_info -- 상품정보 -> 영양정보
        FOREIGN KEY (
                     pno -- 번호
            )
            REFERENCES product_info ( -- 상품정보
                                     pno -- 번호
                );