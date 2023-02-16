# InsuranceCampaign
Projenin Swagger Dökümanına ulaşabilirsiniz
https://app.swaggerhub.com/apis/mikaaillc/insurance-campaign/1.0

------------------------------------------------------------------

- Kullanıcı kampanya oluşturabilmektedir.Bunun için saveCampaing methodunu kullanabilmektedir.Burada kampanya türüne göre durum setlemesi ile ilgili iş kuralı kontrolleri yapılmıştır.
- Burada kampanya türleri için EnumCategory adında enum oluşturulmuştur. Durum yöntimi içinde EnumStatus adında Enum oluşturulmuş bunların değiştirlmeyeceği kabul edilmiştir. Bunlar farklı bir tabloda da tutularak daha dinamik hale getirilebilir.
- Servislerde kullanılan model-entity ilşikisi için yapılan mapperlar generic olarak yapımamasının nedeni bu case için çok fazla model ve entity olamamasıdır. Bunun yerşne generic bir mapper yapılabilir.
- İstatistik dataları için entityManager ile query oluşturulmuştur.Servis ucu eklemiştir.
- Durum değişikliği servisinde yapılan kontroller ise mükerer olan kayıtlar için durum güncellemesi yapılamamaktadır.Bu durum değişkliğinin takibi için log servis oluşturulmuştur önceki durum ve sonraki durum oluşturma tarihi vs. gibi alanlar tutulmuştur.
- H2 Database kullanılmıştır.
- Unit testler için jUnit kullanımıştır.
