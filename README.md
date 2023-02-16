# InsuranceCampaign
Projenin Swagger Dökümanına ulaşabilirsiniz
https://app.swaggerhub.com/apis/mikaaillc/insurance-campaign/1.0

------------------------------------------------------------------

-Kullanıcı kampanya oluşturabilmektedir.Bunun için saveCampaing methodunu kullanabilmektedir.Burada kampanya türüne göre durum setlemesi ile ilgili iş kuralı kontrolleri yapılmıştır.
-Burada kampanya türleri için EnumCategory adında enum oluşturulmuştur. Durum yönetmi içinde EnumStatus adında Enum oluşturulmuş bunların değiştirlmeyeceği kabul edilmiştir.Bunlar farklı bir tabloda da tutularak daha dinamik hale getirilebilir.
-İstatistik dataları için entityManager ile query oluşturulmuştur.Servis ucu eklemiştir.
-Durum değişikliği servisinde Yapılan kontroller ise mükerre olan kayırlar için durum güncellemesi yapılamamktadır.Bu durum değişkliğinin takibi için log servis oluşturulmul önceki durum ve sonraki durum oluşturmaa  tarihi vs. gibi alanlar oluşturulmuştur.
-Unit testler için jUnit kullanımıştır.
