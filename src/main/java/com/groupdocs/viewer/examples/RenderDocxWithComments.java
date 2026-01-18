package com.groupdocs.viewer.examples;

import com.groupdocs.viewer.License;
import com.groupdocs.viewer.Viewer;
import com.groupdocs.viewer.options.HtmlViewOptions;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Demonstrates how to render a DOCX document to HTML while preserving comments using GroupDocs Viewer.
 * <p>
 * The sample reads the input file from {@code resources/input/} folder and writes the rendered HTML to
 * {@code resources/output/}. If a GroupDocs license file is present, it will be loaded; otherwise the library
 * works in evaluation mode with watermarks.
 * </p>
 */
public class RenderDocxWithComments {

    /**
     * Loads a GroupDocs Viewer license if the license file exists.
     *
     * @param licensePath Path to the license file (e.g., "GroupDocs.Viewer.lic").
     * @throws Exception Throws exception if loading fails.
     * @apiNote To obtain a temporary license visit:
     *          <a href="https://purchase.groupdocs.com/temporary-license/">https://purchase.groupdocs.com/temporary-license/</a>.
     *          Place the license file in the project root directory. Without a license the library works in evaluation mode
     *          with watermarks and limited functionality.
     */
    public static void loadLicense(String licensePath) throws Exception {
        File licenseFile = new File(licensePath);
        if (licenseFile.exists()) {
            License license = new License();
            license.setLicense(licensePath);
            System.out.println("GroupDocs Viewer license loaded successfully.");
        } else {
            System.out.println("License file not found at " + licensePath + ". Running in evaluation mode.");
        }
    }

    /**
     * Renders a DOCX document to HTML while preserving comments.
     * <p>
     * Input file: {@code resources/input/sample.docx}
     * Output file: {@code resources/output/sample.html}
     * </p>
     *
     * @throws IOException if file operations fail.
     */
    public static void renderDocxWithComments() throws IOException {
        // Define input and output directories relative to project root
        String inputFilePath = Paths.get("resources", "input", "sample.docx").toString();
        Path outputDir = Paths.get("resources", "output");
        // Ensure output directory exists
        if (!Files.exists(outputDir)) {
            Files.createDirectories(outputDir);
        }
        Path pageFilePathFormat = outputDir.resolve("page_{0}.html");

        // Initialize Viewer with default configuration
        try (Viewer viewer = new Viewer(inputFilePath)) {
            // Create HTML view options with comments rendering enabled
            HtmlViewOptions viewOptions = HtmlViewOptions.forEmbeddedResources(pageFilePathFormat);
            viewOptions.setRenderComments(true);

            // Render document
            viewer.view(viewOptions);
            System.out.println("Document rendered successfully. Output saved to: " + outputDir);
        } catch (Exception e) {
            System.err.println("Error during rendering: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            // Load license if present
            loadLicense("GroupDocs.Viewer.Java.lic");
            // Execute core functionality
            renderDocxWithComments();
        } catch (Exception ex) {
            System.err.println("Unexpected error: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
