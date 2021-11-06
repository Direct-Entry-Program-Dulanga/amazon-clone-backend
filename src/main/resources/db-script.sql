DROP TABLE IF EXISTS item;
CREATE TABLE item(
    code        VARCHAR(10) PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    image       VARCHAR(500) NOT NULL,
    rating      ENUM('1','2','3','4','5') NOT NULL,
    qty         INT NOT NULL,
    unit_price  DECIMAL(5, 2) NOT NULL,
    description MEDIUMTEXT NOT NULL
);

INSERT INTO item VALUES ('I001',
                         'assets/image/headset.jpg',
                         'Oculus Quest 2 — Advanced All-In-One Virtual Reality Headset — 128 GB',
                         3,
                         67,
                         25,
                         '<div>Hi I am dulanga</div>'),
                        ('I002',
                         'assets/image/headset.jpg',
                         'Oculus Quest 2 — Advanced All-In-One Virtual Reality Headset — 128 GB',
                         4,
                         67,
                         25,
                         '<div>Hi I am dulanga</div>'),
                        ('I003',
                         'assets/image/headset.jpg',
                         'Oculus Quest 2 — Advanced All-In-One Virtual Reality Headset — 128 GB',
                         4,
                         67,
                         25,
                         '<div>Hi I am dulanga</div>');