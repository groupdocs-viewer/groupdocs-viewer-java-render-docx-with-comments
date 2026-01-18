# GroupDocs Viewer Java – Render DOCX with Comments

**Project name:** `groupdocs-viewer-java-render-docx-with-comments`

This showcase project demonstrates how to use the **GroupDocs Viewer** Java library (v25.12) to render a DOCX document to HTML while preserving any comments embedded in the document.

---

## Overview

The application reads a DOCX file from the `resources/input/` folder, renders it to HTML pages with comments included, and writes the output to `resources/output/`. It also demonstrates how to load a GroupDocs license file for full‑featured operation.

---

## Prerequisites

- **Java Development Kit (JDK) 8** or newer
- **Apache Maven** 3.6+ 
- Internet connection to download the GroupDocs Maven repository artifacts

---

## License

GroupDocs Viewer requires a license for unrestricted use.

- **Temporary license:** Visit [https://purchase.groupdocs.com/temporary-license/](https://purchase.groupdocs.com/temporary-license/) to obtain a free 30‑day temporary license.
- **Placement:** Put the license file (e.g., `GroupDocs.Viewer.Java.lic`) in the **project root directory** (the same folder that contains `pom.xml`).
- **Without a license:** The library will run in evaluation mode, which adds watermarks and may limit certain functionalities.

---

## Project Structure

```
project-root/
│   pom.xml
│   README.md
│   GroupDocs.Viewer.Java.lic   (optional – place your license file here)
│
├───src/
│   └───main/java/com/groupdocs/viewer/examples/RenderDocxWithComments.java
│
└───resources/
    ├───input/
    │       sample.docx   (replace with your own DOCX file containing comments)
    └───output/
            (generated HTML files will appear here after execution)
```

---

## Setup & Execution

1. **Clone the repository** (or copy the provided files into a new directory):
   ```bash
   git clone https://github.com/your-repo/groupdocs-viewer-java-render-docx-with-comments.git
   cd groupdocs-viewer-java-render-docx-with-comments
   ```

2. **Place your license file** (if you have one) into the project root as `GroupDocs.Viewer.Java.lic`.

3. **Add your DOCX file** with comments:
   - Replace `resources/input/sample.docx` with your own document, keeping the filename or updating the code accordingly.

4. **Build the project** (Maven will download the GroupDocs dependencies from their repository):
   ```bash
   mvn clean compile
   ```

5. **Run the application**:
   ```bash
   mvn exec:java
   ```

6. **Check the output**:
   - After successful execution, `resources/output/page_*.html` will contain the rendered HTML with comments preserved.

---

## Example Usage

```bash
# Assuming you have placed a license file and a DOCX with comments in the input folder
mvn exec:java
```

Console output will indicate whether the license was loaded and where the output HTML file was saved.

---

## Notes

- Make sure the input DOCX file actually contains comments; otherwise no comment markup will appear in the HTML.
- Comments are preserved by enabling `viewOptions.setRenderComments(true)`.
- The `HtmlViewOptions.forEmbeddedResources` method embeds images and other resources directly into the generated HTML pages.
- If you encounter any issues loading the library, verify that your internet connection allows Maven to reach `https://releases.groupdocs.com/java/repo/`.

---

## Contribution

Feel free to fork this repository, enhance the example (e.g., add PDF rendering, add custom CSS), and submit pull requests.

---

*This is a showcase project provided by GroupDocs to illustrate how to render DOCX documents with comments using the GroupDocs Viewer Java API.*