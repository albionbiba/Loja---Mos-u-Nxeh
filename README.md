# Loja - Mos u Nxeh 🎲

**Loja - Mos u Nxeh** është një lojë e thjeshtë me zar e zhvilluar në **Java**, ku dy lojtarë garojnë në një tabelë me 63 kuti. Loja kombinon fatin e zarit me kutitë speciale që mund të ndryshojnë ecurinë e lojës.

## 📖 Përshkrimi
- **2 lojtarë**: secili identifikohet me emrin e dhënë nga përdoruesi.
- **63 kuti**: tabela e lojës përbëhet nga 63 pozicione.
- **1 zar (random)**: lojtarët lëvizin sipas numrit të hedhur.
- **5 kuti speciale**: në pozicionet 6, 13, 27, 45, dhe 58. Nëse lojtari bie aty, kthehet mbrapa 3 hapa.

## 🏆 Mënyrat e lojës
1. **Kush kalon 63 fiton** – lojtari që arrin ose kalon kutinë e fundit shpallet fitues.
2. **Kush shkon fiks 63 fiton** – lojtari duhet të ndalet saktësisht në kutinë e 63-të. Nëse e kalon, kthehet mbrapa sipas diferencës.

## ⚙️ Teknologjia
- Gjuha: **Java**
- Përdor klasa si `Scanner` dhe `Random` nga paketa `java.util`.
- Struktura e kodit:
  - Klasa `Lojtari`: ruan emrin dhe pozicionin e lojtarit.
  - Klasa `LojaMosUNxeh`: përmban logjikën kryesore të lojës.

## ▶️ Si ta ekzekutoni
1. Sigurohuni që keni instaluar **Java JDK**.
2. Kompiloni kodin:
   ```bash
   javac LojaMosUNxeh.java
