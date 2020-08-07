package fi.dy.masa.litematica.gui;

import java.io.File;
import fi.dy.masa.litematica.gui.widgets.WidgetSchematicPlacementBrowser;
import fi.dy.masa.litematica.schematic.placement.SchematicPlacementUnloaded;
import fi.dy.masa.malilib.gui.BaseListScreen;
import fi.dy.masa.malilib.gui.widget.list.entry.DirectoryEntryWidget;
import fi.dy.masa.malilib.gui.widget.list.BaseFileBrowserWidget.DirectoryEntry;
import fi.dy.masa.malilib.util.StringUtils;

public class GuiSchematicPlacementFileBrowser extends BaseListScreen<DirectoryEntry, DirectoryEntryWidget, WidgetSchematicPlacementBrowser>
{
    public GuiSchematicPlacementFileBrowser()
    {
        super(10, 50);

        this.title = StringUtils.translate("litematica.gui.title.schematic_placement_browser");
    }

    @Override
    protected int getListWidth()
    {
        return this.width - 20;
    }

    @Override
    protected int getListHeight()
    {
        return this.height - 68;
    }

    /**
     * This is the string the DataManager uses for saving/loading/storing the last used directory
     * for each browser GUI type/contet.
     * @return
     */
    public String getBrowserContext()
    {
        // Use per-dimension contexts, so that the per-dimension root directory doesn't mess up stuff
        return "schematic_placements" + SchematicPlacementUnloaded.getWorldAndDimPath();
    }

    public File getDefaultDirectory()
    {
        return SchematicPlacementUnloaded.getSaveDirectory();
    }

    @Override
    protected WidgetSchematicPlacementBrowser createListWidget(int listX, int listY)
    {
        // The width and height will be set to the actual values in initGui()
        return new WidgetSchematicPlacementBrowser(listX, listY, 100, 100, this);
    }
}
