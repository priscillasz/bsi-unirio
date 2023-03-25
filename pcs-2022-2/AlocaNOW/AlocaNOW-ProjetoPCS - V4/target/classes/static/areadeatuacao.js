var areasAndSubAreas = {};
areasAndSubAreas['Assurance'] =['Audit', 'CCaSS', 'FAAS', 'Forensics'];

areasAndSubAreas['Consulting'] = ['Business Transformation', 'Finance', 'Enterprise Risk',
    'Financial Services Risk', 'Supply Chain & Operations', 'Technology Risk', 'Cybersecurity', 'Data & Analytics',
    'Digital & Emerging Technologies', 'Technology Solutions Delivery', 'Technology Transformation', 'People Advisory Services (PAS)'];

areasAndSubAreas['Strategy and Transactions'] = ['Lead Advisory', 'Transaction Diligence', 'Valuation, Modeling and Economics',
    'Strategy', 'Transaction Strategy and Execution', 'Turnaround and Restructuring Strategy', 'Internal Tax and Transaction Services'];

areasAndSubAreas['Tax'] = ['Business Tax Services', 'Global Compliance and Reporting', 'Global Law', 'Indirect Tax',
    'International Tax and Transaction Services (ITTS)', 'People Advisory Services', 'Tax Technology and Transformation'];

function ChangeAreaList() {
    var areaList = document.getElementById("area");
    var subAreaList = document.getElementById("subarea");
    var selArea = areaList.options[areaList.selectedIndex].value;
    while (subAreaList.options.length) {
        subAreaList.remove(0);
    }

    var areas = areasAndSubAreas[selArea];

    if (areas) {
        var i;
        for (i = 0; i < areas.length; i++) {
            var area = new Option(areas[i]);
            subAreaList.options.add(area);
        }
    }
}